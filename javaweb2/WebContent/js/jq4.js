$(document).ready(function(){
	var speech = $("div.speech");
	
	var defaultFsize = speech.css("fontSize");    //폰트의 크기를 얻음(px가 따라옴(숫자))
	//alert(defaultFsize);
	
	$("#switcher button").click(function(){
		var num = parseInt(speech.css("fontSize"));  //숫자로 얻었기 때문에 parseInt씀   10px => 16
		//alert(num);
		
		switch(this.id){
		case "switcher-large":
			num += 8;
			break;
		case "switcher-small":
			num -= 8;
			break;
		case "switcher-default":
			//num = defaultFsize;
			num = parseFloat(defaultFsize, 10);   //10진수로 받아들임
			break;
		}
		
		speech.animate({fontSize:num + 'px'}, 'fast');     //animate를 이용하여  effect 주기 / fast, 1000...(숫자)로 많이 씀, slow 안씀
	});
	
	//문서의 일부 보이기 / 숨기기
	var firstPara = $("p:eq(1)");   //p테그의 첫번째를 잡음
	firstPara.hide();
	$("a.more").click(function(){
		if(firstPara.is(":hidden")){    //숨어있니..?
			//firstPara.fadeIn("slow");   //다양한 effect 사용
			firstPara.slideToggle("slow");
			
			$(this).text("read less");
		}else{
			//firstPara.fadeOut("slow");
			firstPara.slideToggle("slow");
			$(this).text("read more");
		}
	});    //a태그에서 more를 클릭하면...
	
	$('button, a.more').hover(
		function(){
			$(this).addClass('myHover');
		},
		function(){
			$(this).removeClass('myHover');
		}
	);
});