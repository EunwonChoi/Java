var xhr;
var checkFirst = loopSend = false;

function sijak(){
	//alert("a");
	if(checkFirst === false){
		kbs = setTimeout("sendKeyword()", 1000);    //setInterval() 지연시간을 줌
		loopSend = true;   //첫번재 글자 이후의 글자들
	}
}

function sendKeyword(){
	//console.log('good');
	if(loopSend === false) return;
	
	var keyWord = document.frm.keyword.value;
	//console.log(keyWord);
	if(keyWord === ""){
		hide();
	}else{
		var para = "keyword=" + keyWord;

		xhr = new XMLHttpRequest();
		xhr.open("post", "ajax7.jsp", true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4){
				if(xhr.status == 200){
					processPost();
				}else{
					alert('err: ' + xhr.status);
				}
			}
		}
		xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
		xhr.send(para);  
	}
	//clear Timeout();
}

function processPost(){
	var data = xhr.responseText;
	//alert(data);     ex)5|김00,김00,김00,김00,김00
	var result = data.split("|");
	var tot = result[0];   //건수
	if(tot > 0){
		var datas = result[1].split(",");    //김00,김00,....
		var imsi = "";
		for(var i=0; i<datas.length; i++){
			imsi += "<a href=\"javascript:func('" + datas[i] + "')\">" + datas[i] + "</a><br>"
		}
		//alert(imsi);
	}
	var listView = document.getElementById("suggestlist");   //리스트들을 뽑아서 보여줌
	listView.innerHTML = imsi;
	show();
}

function func(arg){
	//alert(arg);
	frm.sel.value = arg;
	
	//사라짐
	loopSend = checkFirst = false;
	hide();
	frm.keyword.value="";
}

function hide(){
	document.getElementById("suggest").style.display="none";
}

function show(){
	document.getElementById("suggest").style.display="";
}