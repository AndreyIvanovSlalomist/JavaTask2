 <html>
       <head>
           <title>Сотрудники</title>
           <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
       </head>
       <body>
       <div class="container">
         <h2>Сотрудники</h2>
           <a href="/addemployee"><div class="btn btn-primary" style="float: left">Добавить</div></a>
           <form action="/loadFromFile" method="POST" enctype="multipart/form-data" class="form-inline">

            <div class="form-group" for="file">
                <input type="file" name="file"  class="form-control-file" ></div>
            <input type="submit" class="btn btn-primary form-control" value="Загрузить">
           </form>

        <table  class="table table-hover" id="table">
                  <tr>
                   <th>Номер сотрудника</th>
                   <th>Имя сотрудника </th>
       		    <th>Должность сотрудника </th>
       		    <th>Дата принятия на работу </th>
       		    <th>Зар.плата</th>
                    <th></th>
                  </tr>
                  <#list employeesFromServer as employee>
                  <tr>
                    <td>${employee.id!""}</td>
                    <td>${employee.name!""}</td>
                    <td>${employee.job!""}</td>
                    <td>${employee.hireDate!""}</td>
                    <td>#{employee.salary!""}</td>
                    <td align="right" nowrap>
                       <a href="/editemployee?employee_id=${employee.id}"><div class="btn btn-primary title="Редактировать">&#9998</div></a>
                       <a href="/deleteemployee?employee_id=${employee.id}"><div class="btn btn-primary title="Удалить">&#10007</div></a>
                    </td>
                  </tr>
                  </#list>
                </table>

       </div>
       </body>
       </html>