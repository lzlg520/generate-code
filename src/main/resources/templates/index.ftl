<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>项目生成器</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.4.1/dist/css/bootstrap.min.css"/>
</head>
<body>
<div class="container">
    <h1 class="col-sm-offset-5">项目生成器</h1>
    <form class="form-horizontal" role="form" id="generateCodeForm">
        <div class="form-group">
            <label for="groupId" class="col-sm-2 control-label">GroupId</label>
            <div class="col-sm-10">
                <input type="text" required class="form-control" id="groupId" placeholder="请输入组织名">
            </div>
        </div>
        <div class="form-group">
            <label for="artifactId" class="col-sm-2 control-label">ArtifactId</label>
            <div class="col-sm-10">
                <input type="text" required class="form-control" id="artifactId" placeholder="请输入项目名称">
            </div>
        </div>
        <div class="form-group">
            <label for="url" class="col-sm-2 control-label">数据库链接</label>
            <div class="col-sm-10">
                <input type="text" required class="form-control" id="url" placeholder="请输入数据库连接">
            </div>
        </div>
        <div class="form-group">
            <label for="username" class="col-sm-2 control-label">数据库用户</label>
            <div class="col-sm-10">
                <input type="text" required class="form-control" id="username" placeholder="请输入数据库用户">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label">数据库密码</label>
            <div class="col-sm-10">
                <input type="password" required class="form-control" id="password" placeholder="请输入数据库密码">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-2 col-sm-3">
                <button type="submit" onclick="download(1)" class="btn btn-default">生成项目</button>
            </div>
        </div>
    </form>
</div>
</body>
<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
<script>
    var download = function (a) {
        $("#generateCodeForm").submit(function () {
            var url = encodeURIComponent($("#url").val());
            var type = "code";
            if (a === 2) {
                type = "jar";
            }
            window.open("http://39.98.152.124:52000/generate/" + type + "?groupId=" +
                $("#groupId").val() + "&artifactId=" + $("#artifactId").val() + "&url=" + url
                + "&username=" + $("#username").val() + "&password=" + $("#password").val());
            return false;
        });
    };
</script>
</html>