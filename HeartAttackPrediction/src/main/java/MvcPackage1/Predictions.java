package MvcPackage1;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.classification.DecisionTreeClassificationModel;
import org.apache.spark.ml.classification.DecisionTreeClassifier;
import org.apache.spark.ml.classification.GBTClassificationModel;
import org.apache.spark.ml.classification.GBTClassifier;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.classification.LogisticRegressionModel;
import org.apache.spark.ml.classification.RandomForestClassificationModel;
import org.apache.spark.ml.classification.RandomForestClassifier;
import org.apache.spark.ml.evaluation.MulticlassClassificationEvaluator;
import org.apache.spark.ml.evaluation.RegressionEvaluator;
import org.apache.spark.ml.feature.VectorAssembler;
import org.apache.spark.ml.linalg.Vector;
import org.apache.spark.ml.linalg.Vectors;
import org.apache.spark.ml.param.ParamMap;
import org.apache.spark.ml.tuning.ParamGridBuilder;
import org.apache.spark.ml.tuning.TrainValidationSplit;
import org.apache.spark.ml.tuning.TrainValidationSplitModel;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class Predictions {

	public static double[] logisticRegression(double age,double sex,double cp,double trtbps,double chol,double fbs,double restecg,double thalachh,double exng,double oldpeak,double slp,double caa,double thall) {

		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("HearAnalysis").master("local[*]").getOrCreate();
		Dataset<Row> heart = spark.read().option("header", true).option("inferSchema", true)
				.csv("heart.csv");
		// heart.show();

		Dataset<Row> heart_no_op = heart.drop("output");
		// heart_no_op.show();
		heart = heart.withColumnRenamed("output", "label");
		VectorAssembler vectorAssembler = new VectorAssembler();
		Dataset<Row> inputData = vectorAssembler
				.setInputCols(new String[] { "age", "sex", "cp", "trtbps", "chol", "fbs", "restecg", "thalachh", "exng",
						"oldpeak", "slp", "caa", "thall" })
				.setOutputCol("features").transform(heart).select("features", "label");

		Dataset<Row>[] trainAndHoldoutData = inputData.randomSplit(new double[] { 0.8, 0.2 });
		Dataset<Row> trainAndTestData = trainAndHoldoutData[0];
		Dataset<Row> holdOutData = trainAndHoldoutData[1];

		LogisticRegression logisticRegression = new LogisticRegression();

		ParamGridBuilder pgb = new ParamGridBuilder();
		ParamMap[] paramMap = pgb.addGrid(logisticRegression.regParam(), new double[] { 0.01, 0.1, 0.3, 0.5, 0.7, 1 })
				.addGrid(logisticRegression.elasticNetParam(), new double[] { 0, 0.5, 1 }).build();

		TrainValidationSplit tvs = new TrainValidationSplit();
		tvs.setEstimator(logisticRegression).setEvaluator(new RegressionEvaluator().setMetricName("r2"))
				.setEstimatorParamMaps(paramMap).setTrainRatio(0.9);

		TrainValidationSplitModel model = tvs.fit(trainAndTestData);
		LogisticRegressionModel lrModel = (LogisticRegressionModel) model.bestModel();
		//Dataset<Row> pred1=lrModel.transform(holdOutData);
		double acc1=lrModel.summary().accuracy();
		Vector feat = Vectors.dense(age,sex,cp,trtbps,chol,fbs,restecg,thalachh,exng,oldpeak,slp,caa,thall);
		double ans = (double) lrModel.predict(feat);
		double lr[]= {ans,acc1};
		return lr;
	}
	


	public double[] decesionTree(double age,double sex,double cp,double trtbps,double chol,double fbs,double restecg,double thalachh,double exng,double oldpeak,double slp,double caa,double thall) {

		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("HearAnalysis").master("local[*]").getOrCreate();
		Dataset<Row> heart = spark.read().option("header", true).option("inferSchema", true)
				.csv("heart.csv");
		// heart.show();

		Dataset<Row> heart_no_op = heart.drop("output");
		// heart_no_op.show();
		heart = heart.withColumnRenamed("output", "label");
		VectorAssembler vectorAssembler = new VectorAssembler();
		Dataset<Row> inputData = vectorAssembler
				.setInputCols(new String[] { "age", "sex", "cp", "trtbps", "chol", "fbs", "restecg", "thalachh", "exng",
						"oldpeak", "slp", "caa", "thall" })
				.setOutputCol("features").transform(heart).select("features", "label");

		Dataset<Row>[] trainAndHoldoutData = inputData.randomSplit(new double[] { 0.8, 0.2 });
		Dataset<Row> trainAndTestData = trainAndHoldoutData[0];
		Dataset<Row> holdOutData = trainAndHoldoutData[1];

		DecisionTreeClassifier dtClassifier = new DecisionTreeClassifier();
		dtClassifier.setMaxDepth(3);
		DecisionTreeClassificationModel dtmodel = dtClassifier.fit(trainAndTestData);
		Dataset<Row> pred2=dtmodel.transform(holdOutData);
		MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator();
        evaluator.setMetricName("accuracy");
        double acc2=evaluator.evaluate(pred2);
		Vector feat = Vectors.dense(age,sex,cp,trtbps,chol,fbs,restecg,thalachh,exng,oldpeak,slp,caa,thall);
		double ans = (double) dtmodel.predict(feat);
		double dt[] = {ans,acc2};
		return dt;

		
	}

	public double[] randomForest(double age,double sex,double cp,double trtbps,double chol,double fbs,double restecg,double thalachh,double exng,double oldpeak,double slp,double caa,double thall) {

		Logger.getLogger("org.apache").setLevel(Level.WARN);
		SparkSession spark = SparkSession.builder().appName("HearAnalysis").master("local[*]").getOrCreate();
		Dataset<Row> heart = spark.read().option("header", true).option("inferSchema", true)
				.csv("heart.csv");
		// heart.show();

		Dataset<Row> heart_no_op = heart.drop("output");
		// heart_no_op.show();
		heart = heart.withColumnRenamed("output", "label");
		VectorAssembler vectorAssembler = new VectorAssembler();
		Dataset<Row> inputData = vectorAssembler
				.setInputCols(new String[] { "age", "sex", "cp", "trtbps", "chol", "fbs", "restecg", "thalachh", "exng",
						"oldpeak", "slp", "caa", "thall" })
				.setOutputCol("features").transform(heart).select("features", "label");

		Dataset<Row>[] trainAndHoldoutData = inputData.randomSplit(new double[] { 0.8, 0.2 });
		Dataset<Row> trainAndTestData = trainAndHoldoutData[0];
		Dataset<Row> holdOutData = trainAndHoldoutData[1];

		RandomForestClassifier rfClassifier = new RandomForestClassifier();
		rfClassifier.setMaxDepth(3);
		RandomForestClassificationModel rfModel = rfClassifier.fit(trainAndTestData);
		Dataset<Row> pred3=rfModel.transform(holdOutData);
		MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator();
        evaluator.setMetricName("accuracy");
        double acc3=evaluator.evaluate(pred3);
		Vector feat = Vectors.dense(age,sex,cp,trtbps,chol,fbs,restecg,thalachh,exng,oldpeak,slp,caa,thall);
		double ans = (double) rfModel.predict(feat);
		
		double rf[]= {ans,acc3};
		return rf;
	}

	public double[] gradientBoost(double age,double sex,double cp,double trtbps,double chol,double fbs,double restecg,double thalachh,double exng,double oldpeak,double slp,double caa,double thall) {
		
		Logger.getLogger("org.apache").setLevel(Level.WARN);
        SparkSession spark= SparkSession.builder().appName("HearAnalysis").master("local[*]")
                .getOrCreate();
        Dataset<Row> heart = spark.read().option("header", true).option("inferSchema", true)
				.csv("heart.csv");
        //heart.show();
      

        Dataset<Row> heart_no_op=heart.drop("output");
        //heart_no_op.show();
        heart=heart.withColumnRenamed("output","label");
        VectorAssembler vectorAssembler=new VectorAssembler();
        Dataset<Row> inputData=vectorAssembler.setInputCols(new String[]{"age","sex","cp","trtbps","chol","fbs","restecg","thalachh","exng","oldpeak","slp","caa","thall"})
                .setOutputCol("features")
                .transform(heart).select("features","label");

        Dataset<Row>[] trainAndHoldoutData = inputData.randomSplit(new double[] {0.8,0.2});
        Dataset<Row> trainAndTestData = trainAndHoldoutData[0];
        Dataset<Row> holdOutData = trainAndHoldoutData[1];
        
        GBTClassifier gbt=new GBTClassifier();
        gbt.setMaxDepth(3);
        GBTClassificationModel gbtModel=gbt.fit(trainAndTestData);
        Dataset<Row> pred4=gbtModel.transform(holdOutData);
		MulticlassClassificationEvaluator evaluator = new MulticlassClassificationEvaluator();
        evaluator.setMetricName("accuracy");
        double acc4=evaluator.evaluate(pred4);
        Vector feat = Vectors.dense(age,sex,cp,trtbps,chol,fbs,restecg,thalachh,exng,oldpeak,slp,caa,thall);
        double ans = (double) gbtModel.predict(feat);
        double gb[]= {ans,acc4};
        
        return gb;
        
	}
	
}