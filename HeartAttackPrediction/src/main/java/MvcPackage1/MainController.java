package MvcPackage1;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.spark.ml.classification.LogisticRegression;
import org.apache.spark.ml.classification.LogisticRegressionModel;
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
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	@RequestMapping("link")
	public ModelAndView resultsPage() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ResultsPage");
		return mv;
	}
	
		
	
	@RequestMapping(value = "getDetails", method = RequestMethod.GET)
	public ModelAndView getDetails(HttpServletRequest request, HttpServletResponse response){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("ShowDetails");
//		{"age","sex","cp","trtbps","chol","fbs","restecg","thalachh","exng","oldpeak","slp","caa","thall"})
		
		Double age1 = Double.parseDouble(request.getParameter("age"));
		Double sex1 = Double.parseDouble(request.getParameter("sex"));
		Double cp1 = Double.parseDouble(request.getParameter("cp"));
		Double trtbps1 = Double.parseDouble(request.getParameter("trtbps"));
		Double chol1 = Double.parseDouble(request.getParameter("chol"));
		Double fbs1 = Double.parseDouble(request.getParameter("fbs"));
		Double restecg1 = Double.parseDouble(request.getParameter("restecg"));
		Double thalachh1 = Double.parseDouble(request.getParameter("thalachh"));
		Double exng1 = Double.parseDouble(request.getParameter("exng"));
		Double oldpeak1 = Double.parseDouble(request.getParameter("oldpeak"));
		Double slp1 = Double.parseDouble(request.getParameter("slp"));
		Double caa1 = Double.parseDouble(request.getParameter("caa"));
		Double thall1 = Double.parseDouble(request.getParameter("thall"));
		
		System.out.println("OK DONE");
		
//		Vector feat = Vectors.dense(ans,sex,cp,trtbps,chol,fbs,restecg,thalachh,exng,oldpeak,slp,caa,thall);
		
		Predictions pred = new Predictions();
		System.out.println("reading error");
		double[] ans1 = pred.logisticRegression(age1,sex1,cp1,trtbps1,chol1,fbs1,restecg1,thalachh1,exng1,oldpeak1,slp1,caa1,thall1);
		mv.addObject("ans1", ans1[0]);
		mv.addObject("acc1",ans1[1]);
		
		
		double[] ans2 = pred.decesionTree(age1,sex1,cp1,trtbps1,chol1,fbs1,restecg1,thalachh1,exng1,oldpeak1,slp1,caa1,thall1);
		mv.addObject("ans2", ans2[0]);
		mv.addObject("acc2",ans2[1]);
		
		double[] ans3 = pred.gradientBoost(age1,sex1,cp1,trtbps1,chol1,fbs1,restecg1,thalachh1,exng1,oldpeak1,slp1,caa1,thall1);
		mv.addObject("ans3", ans3[0]);
		mv.addObject("acc3",ans3[1]);
		
		double[] ans4 = pred.randomForest(age1,sex1,cp1,trtbps1,chol1,fbs1,restecg1,thalachh1,exng1,oldpeak1,slp1,caa1,thall1);
		mv.addObject("ans4", ans4[0]);
		mv.addObject("acc4",ans4[1]);
		
		System.out.println(ans1+" "+ ans2+" "+ ans3+" "+ ans4);
		
		return mv;
		
		
		
	}
	
	
	
	

}