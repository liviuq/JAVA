<html>
<head>
    <title>Welcome!</title>
</head>
<body>
<h1>Welcome to the webpage of ${title}</h1>
<p><h2>We currently have the following books:</h2>
<table border="1">
    <tr><td>ID<td>TITLE<td>LOCATION</td></tr>
    <#list items as item>
    <tr><td>${item.id}<td>${item.title}<td>${item.location}
            </#list>
</table>
</body>
</html>