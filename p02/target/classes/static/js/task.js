
$(document).ready(function() {	
	$('#btn').click(function(){
		var id=document.getElementById("id1").value;
		//alert(id);
		$.ajax({
			type: "get",
	        url: "https://localhost:8080/task/"+id,
		 	dataType: "Json"
	    }).then(function(data) {
	    	console.log(data);
	    	
	    	var t = eval(data); //强制转换一下json字符串，生成json对象
	    	console.log(t)
	    	if(t.__proto__.constructor.length==1){
	    		var row = $("#template").clone();
	    		console.log(row)
	    		row[0].children[0].innerText=t.id
	    		row[0].children[2].innerText=t.discription;
	    		row.appendTo($("#testTable"));
	    	}else{
	            $.each(t, function () { 
	                var row = $("#template").clone(); //克隆模板，创建一个新数据行
	                console.log(row);
	                console.log(this);
	                /*for (attribute in n) { 
	                	console.log(n[attribute]);
	                    row.find("#" + attribute).html(n[attribute]); //循环json对象的属性，并赋值到数据行中对应的列，此处列的id就是相应的属性名称 
	                }*/ 
	                
	                row.appendTo($("#testTable")); 
	            });
	    	}
	    });
	});    
});