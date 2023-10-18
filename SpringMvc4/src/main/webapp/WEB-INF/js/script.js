/**
 * 
 */
 $(function(){
 	$("#myimg").attr("src","../image/poster1.jpeg");
 		
 		
 		$("#myimg").mouseover(function(){
        imgsrc=$(this).attr("src");
        $(this).attr("src","../image/op9.jpeg");    
    })

    $("#myimg").mouseout(function(){
        $(this).attr("src","../image/poster1.jpeg");
    })
    	
  
    $("#myimg").click(function(){
        $(this).attr("src","../image/rightarrow.png");
    });
    
 
 });
    /*
    $("#myimg").hover(function(){
    $(this).hover
    */