$(document).ready(function(){
	$("#addForm").hide();
	$("#delForm").hide();
	$("#code_err1").hide();
	$("#code_err2").hide();
	$("#sang_err").hide();
	$("#su_err").hide();
	$("#dan_err").hide();
	$("#dcode_err").hide();
	
	$("#btn_addSangpum").click(function(){
		$("#addForm").slideToggle("fast");
		$("#txtCode").focus();
	});
	
	$("#btn_delSangpum").click(function(){
		$("#delForm").slideToggle("fast");
		$("delCode").focus();
	});
	
	
	$("#btn_insertCancel").click(function(){  //추가 취소
		$("#txtCode").val("");
		$("#txtSang").val("");
		$("#txtSu").val("");
		$("#txtDan").val("");
		$("#addForm").slideToggle("fast");
	});
	
	$("#btn_deleteCancel").click(function(){  //삭제 취소
		$("#delCode").val("");
		$("#delForm").slideToggle("fast");
	});
	
	$("#btn_dispAll").click(dispAll);    //전체 자료 출력
	$("#btn_insertData").click(insertData);    //추가
	$("#btn_deleteData").click(deleteData);    //삭제
	
});

function dispAll(){
	//alert("a");
	$.getJSON("jq_crud_select.jsp", function(data){
		$("#disp").empty();
		//alert(data);
		var str = "<table><tr><th>코드</th><th>상품명</th><th>수량</th><th>단가</th></tr>";
		$.each(data, function(ind, entry){
			str += "<tr>";
			str += "<td>" + entry["code"] + "</td>";
			str += "<td>" + entry["sang"] + "</td>";
			str += "<td>" + entry["su"] + "</td>";
			str += "<td>" + entry.dan + "</td>";
			str += "</tr>"
		});
		str +="</table>";
		$("#disp").append(str);
	});
}

function insertData(){
	//alert("b");
	var code = $("#txtCode").val();
	var sang = $("#txtSang").val();
	var su = $("#txtSu").val();
	var dan = $("#txtDan").val();
	
	//코드 검사
	//입력확인
	if(code.length < 1){
		$("#code_err1").show();
		return false;
	}else{
		$("#code_err1").hide();
	}
	//숫자확인 
	for(var i=0; i<code.length; i++){
		var data = code.charAt(i).charCodeAt(0);   //charCodeAt() 문자열 중 하나를 ascii code로 변환
		//alert(data);
		if(data < 48 || data > 57){
			$("#code_err2").show();
			return false;
		}else{
			$("#code_err2").hide();
		}
	}
	
	//상품 검사
	if(sang.length < 1){
		$("#sang_err").show();
		return false;
	}else{
		$("#sang_err").hide();
	}
	
	//수량 검사
	if(isNaN(su) || su.length < 1){
		$("#su_err").show();
		return false;
	}else{
		$("#su_err").hide();
	}
	
	//단가 검사
	if(isNaN(dan) || dan.length < 1){
		$("#dan_err").show();
		return false;
	}else{
		$("#dan_err").hide();
	}
	
	//추가 작업 : Ajax
	$.ajax({
		type:"post",
		url:"jq_crud_ins.jsp",
		data:{"code":code,"sang":sang,"su":su,"dan":dan},
		success:function(data){
			alert(data);
			if(data === "f"){
				alert("상품 추가 실패");
				return false;
			}
			//alert("상품 추가 성공");
			$("#txtCode").val("");
			$("#txtSang").val("");
			$("#txtSu").val("");
			$("#txtDan").val("");
			$("#addForm").slideToggle("fast");
			dispAll();   //추가 후 목록 보기
		}, error:function(){
			alert("ins error");
		}
	});
}

function deleteData(){
	//alert("c");
	var dcode = $("#delCode").val();
	
	if(isNaN(dcode) || dcode.length < 1){
		$("#dcode_err").show();
		return false;
	}else{
		$("#dcode_err").hide();
	}
	
	//삭제 계속
	$.ajax({
		type:"post",
		url:"jq_crud_del.jsp",
		data:{"dcode":dcode},
		success:function(data){
			alert(data);
			if(data === "f"){
				alert("상품 삭제 실패");
				return false;
			}
			//alert("상품 삭제 성공");
			$("#delCode").val("");

			$("#delForm").slideToggle("fast");
			dispAll();   //삭제 후 목록 보기
		}, error:function(){
			alert("del error");
		}
	});
}