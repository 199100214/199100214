<%--
  Created by IntelliJ IDEA.
  User: Lenovo
  Date: 2022/3/27
  Time: 14:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.0/jquery.js"></script>
    <script>
        $(function () {
            // $("#btn1").html(123);
            // $("#btn1").click(function () {
            //     $("#div01").html(123);
            // })
            $("#btn1").click(function x() {
                    $.ajax({
                        url:"test.do",
                        // data:"key=value&key=value",//为后台传递数据
                        // async:true or false 默认为true 异步刷新
                        type:"get",
                        dataType:"json",
                        success:function (data) {
                            //data:从后台返回的数据
                            $("#div01").html(data);
                            alert(data.str2)
                        }
                    })


                }
            )
        })

    </script>
</head>
<body>
<button id="btn1">点击</button>
<div id="div01" style="border: solid pink;width: 200px;height: 200px">

</div>
<div id="div02" style="border: solid pink;width: 200px;height: 200px">
${pageContext.request.contextPath}
</div>
</body>
</html>
