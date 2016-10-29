

var desc = $(".intcoNav span:nth-child(1)");
var discuss = $(".intcoNav span:nth-child(2)");

$(function(){
		descInit();
		
		
		var jobData = null;
		desc.click(function(){
//			if($(".comment").data("index")==1){
//				return;
//			}
			
			$.post("../servlet/JobServlet",'{requestCode:"30003",count:5,start:0}',function(data){
				jobData = eval("("+data+")");
				alert(jobData.list[0].jobAddress)
				$(".userIntro")[0].innerHTML = jobData.list[0];
			});
			
		})
		discuss.click(function(){
//			if($(".introduce").data("index")==1){
//				return;
//			}
			$.get("../servlet/TestServlet",'dhjfahsh',function(data){
				alert("data")
			});
		})
		
	}
);










/** 
 * 插入详情
 * 
 */
function descInnerHtml(data){
	
}

/**
 * 
 * 插入评论
 * */
function discussInnerHtml(data){
	
}

/** 
 * 初始化整个页面默认加载详情
 * 
 */
function descInit(){
	console.log($(".comment").data("index"))
}









