<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Gerenciamento de Pais</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
</head>

<body>
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
        <!-- Brand -->
        <a class="navbar-brand" href="#">App</a>

        <!-- Toggler/collapsibe Button -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Navbar links -->
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a class="nav-link" href="#">Consumidor</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="#">Pais</a>
                </li>
            </ul>
        </div>
    </nav>

    <div class="container-fluid mt-3">
        <div class="card">
            <div class="card-header">
                <h3>Gerenciamento de Paises</h3>
            </div>
            <div class="card-body">
                <div>

                <#if paisAtual??>
                    <form method="post" action="/pais/alterar">
                        <div class="float-right mt-1 mb-1">
                            <input type="submit" class="btn btn-warning" value="Alterar"></input>
                        </div>
                <#else>
                    <form method="post" action="/pais/criar">
                        <div class="float-right mt-1 mb-1">
                            <input type="submit" class="btn btn-primary" value="Criar"></input>
                        </div>
                </#if>

                        <input type="hidden" name="id" value="${(paisAtual.id)!}"></input>

                        <div class="form-group">
                            <label for="nome">Nome:</label>
                            <input value="${(paisAtual.nome)!}" name="nome" type="text" class="form-control" id="nome" placeholder="Brasil">
                        </div>
                        <div class="form-group">
                            <label for="sigla">Sigla:</label>
                            <input value="${(paisAtual.sigla)!}" name="sigla" type="text" class="form-control" id="sigla" placeholder="BR">
                        </div>
                    </form>
                </div>

                <div class="mt-3">
                    <table class="table">
                        <thead class="thead-dark">
                            <tr>
                                <th>Nome</th>
                                <th>Sigla</th>
                                <th>Ações</th>
                            </tr>
                        </thead>
                        <tbody>
                            <#list listaPaises as pais>
                                <tr>
                                    <td>${pais.nome}</td>
                                    <td>${pais.sigla}</td>
                                    <td>
                                        <a href="/pais/preparaAlterar/${pais.id}" class="btn btn-warning">Alterar</a>
                                        <a href="/pais/apagar/${pais.id}" class="btn btn-danger">Excluir</a>
                                    </td>
                                </tr>
                            </#list>

                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer"></div>
        </div>
    </div>


    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

    <!-- Popper JS -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
</body>

</html>