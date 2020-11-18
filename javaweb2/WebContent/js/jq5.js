$(document).ready(function(){
	//alert("a");
	
	//xml에서는 find를 쓰지만 json에서는 find를 쓰지 않음
	
	
	//1. html 읽기
	$('#test1').click(function(){
		$("#disp").empty();     //내용 지움
		$("#disp").load("jq5h.html");
	});
	
	
	
	
	
	//2. json 읽기
	$('#test2').click(function(){
		$("#disp").empty();    //내용 지움
		$.getJSON("jq5j1.json", function(data){   //json용 method임, data는 파라미터로 값이 들어옴
			//alert(data);
			$.each(data, function(keyindex, value){     //key와 value가 넘어옴(반복으로 돌림),   **기억:   $.each  는 반복문 쓸 때!
				//alert(keyindex + " " + value);
				var str = "<ol>";
				str += "<li>" + value["title"] + "</li>";
				str += "<li>" + value["desc"] + "</li>";
				str += "<li>" + value["author"] + "</li>";
				str += "</ol>";
				$("#disp").append(str);
			});
		});   
	});
	
	
	
	
	
	
	//3. json 읽기
	$('#test3').click(function(){
		$("#disp").empty();    //내용 지움
		var items = [];    //배열에 넣어놓고 뽑아보기
		$.getJSON("jq5json.jsp", function(data){   //json용 method임
			$.each(data, function(keyindex, value){     //key와 value가 넘어옴(반복으로 돌림),   **기억:   $.each  는 반복문 쓸 때!
				//alert(keyindex + " " + value);
				var str = "<ol>";
				str += "<li>" + value["code"] + "</li>";
				str += "<li>" + value["sang"] + "</li>";
				str += "<li>" + value["su"] + "</li>";
				str += "<li>" + value["dan"] + "</li>";
				str += "</ol>";
				//$("#disp").append(str);
				items.push(str);  //배열에 넣어놓음
			});
			$("<b/>", {html:items}).appendTo("#disp");    //appendTo를 쓰면 disp뒤로 들어감
		}); 
	});
	
	
	
	
	
	//4. xml 읽기
	$('#test4').click(function(){
		$("#disp").empty();    //내용 지움
		$.get("jq5x1.xml", function(data){
			//alert(data);
			//alert($(data).find("aa").size());     //"aa"의 size를 찾아봐!(find는 하위의 method를 찾아봄)
			$(data).find("aa").each(function(){     //each 써서 반복함
				var fdata = $(this);    //현재 읽힌 aa 요소(element)
				var str ="<div>";
				str += fdata.attr("part") + " " + fdata.attr("term");
				str += " - ";
				str += fdata.find("desc").text();    //childNode써도 됨
				str += "</div>";
				$("#disp").append(str);
			});
		});
	});
	
	
	
	
	
	//5. xml 읽기
	$('#test5').click(function(){
		$("#disp").empty();    //내용 지움
		$.post("jq5xml.jsp", function(data){     //get말고 post도 가능
			$(data).find("sangpum").each(function(){
				var sangpum = $(this);
				var str = "<div>";
				str += sangpum.find("code").text() + " ";
				str += sangpum.find("sang").text() + " ";
				str += sangpum.find("su").text() + " ";
				str += sangpum.find("dan").text() + " ";
				str += "</div>";
				$("#disp").append(str);
			});
		});
	});
	
	
});