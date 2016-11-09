$(".search").keyup(function(){
				$.ajax({
					type:"post",
					url:"KeyWordServlet",
					data:{searchName:$(".search").val()},
					success:function(data){
						$("#hide-info").html("");
						var arry = data.substring(1,data.length-1).split(',');
						if(arry!=""&&arry.length>0){
							for(var i = 0;i<arry.length;i++){
								$("#hide-info").append("<li class='list-group-item'><a href=''>"+arry[i]+"</a></li>")
							}
							$("#hide-info").css("display","block");
						}
						else{
							$("#hide-info").css("display","none");
						}
						
					},
					error:function(){
						alert("出现了一点错误")
					},
					dataType:"text"
				});
})