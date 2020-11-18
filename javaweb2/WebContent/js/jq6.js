$(document).ready(function() {

	 //xml(값이 나와있음)
	$("#btn1").on("click", function() {   
		$("#disp").empty();    //내용 지움
		$.ajax({      //function안쓰고 바로 객체 만들어버림
			type:"get",    //get, post 둘 다 가능
			url:"jq6xml1.jsp",
			dataType:"xml",
			success:function(data){
				//alert(data);
				var str ="";
				$(data).find("person").each(function(){
					str += $(this).find("irum").text() + "&nbsp;"
				});
				$("#disp").append(str);
			}, error:function(){
				alert("error");
			}
			/*
			, statusCode:{     //여기처럼 추가적으로 줄 수도 있음
				200:function(){
					alert("읽기 성공");
				}, 404:function(){
					alert("찾기 실패");
				}
			}
			*/
		});
	});

	
	
	
	//xml(값을 받아야함)
	$("#btn2").on("click", function() {    
		$("#disp").empty();    //내용 지움
		$.ajax({      //function안쓰고 바로 객체 만들어버림
			type:"get",
			url:"jq6xml2.jsp",	
			//data:"irum=" + "손오공",
			data: {"irum":"삼장법사"},     //data넣으면 됨
			dataType:"xml",
			success:function(data){
				//alert(data);
				var str ="";
				$(data).find("person").each(function(){
					str += $(this).find("irum").text() + "&nbsp;"
				});
				$("#disp").append(str);
			}, error:function(){
				alert("error");
			}
		});
	});

	
	
	
	//json(값이 나와있음)
	$("#btn3").on("click", function() {    
		$("#disp").empty();    //내용 지움
		$.ajax({
			type:"get",
			url:"jq6json1.jsp",
			dataType:"json",
			success:function(data){
				var str = "";
				$.each(data, function(index, entry){
					str += entry["name"] + ", " + entry.age;    //앞에꺼처럼 써도 되고 뒤에꺼처럼 써도 됨
				});
				$("#disp").append(str);
			}, error:function(){
				alert("error");
			}
		});
	});

	
	
	
	//json(값을 받아야함)
	$("#btn4").on("click", function() {     
		$("#disp").empty();    //내용 지움
		$.ajax({
			type:"get",
			url:"jq6json2.jsp",
			//data:"irum=" + "장비" + "&nai=" + "35",
			data:{"irum":"유비", "nai":"33"} ,      //data 넣으면 됨
			dataType:"json",
			success:function(data){
				var str = "";
				$.each(data, function(index, entry){
					str += entry["name"] + ", " + entry.age;    //앞에꺼처럼 써도 되고 뒤에꺼처럼 써도 됨
				});
				$("#disp").append(str);
			}, error:function(){
				alert("error");
			}
		});
	});

});