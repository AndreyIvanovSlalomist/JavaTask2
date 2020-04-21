<html>
<head>
    <title>Редактировать трек</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
</head>
<body>
<div class="container">
    <h2>Новый сотрудник</h2>
    <form action="/addemployee" method="POST" autocomplete="off">
        <div class="form-group" for="name">
            <input autofocus required = true type="text" class="form-control" name="name" id="name" placeholder="Имя сотрудника" ">
        </div>
        <div class="form-group" for="job">
            <input required = true type="text" class="form-control" name="job" id="job" placeholder="Должность сотрудника" >
        </div>
        <div class="form-group" for="hireDate">
            <input required = true type="date" class="form-control" name="hireDate" id="hireDate" placeholder="Дата принятия на работу">
        </div>
        <div class="form-group" for="salary">
            <input required = true type="number" class="form-control" name="salary" id="salary" placeholder="Зар.плата" min="0" step="1">
        </div>
        <input type="submit" class="btn btn-primary" value="Сохранить">
        <a href="/employees"><div class="btn btn-primary">Отмена</div></a>
    </form>
</div>
</body>
</html>