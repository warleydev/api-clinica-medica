# API CLÍNICA MÉDICA

## Sobre o projeto
Este é um projeto feito para uma clínica médica, na qual é possível cadastrar clientes e médicos, e a partir deles agendar consultas com todas exceções sendo tratadas, utilizando Spring Framework para o projeto como um todo, banco de dados MySQL, e Spring Security para autenticação e autorização utilizanado Token JWT

<h2>Endpoints</h2>
<div>
  <h2>/pacientes-</h2>
  <div>
    <h3>POST:</h3>
   <p>Neste endpoint POST, inserimos pelo corpo da requisição um médico com as informações mostradas na imagem, tratando a validação das informações.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/4e061800-be81-494f-ba7c-28d4b975ccdb">
  </div>
  <div>
    <h3>GET: </h3>
    <p>Neste endpoint GET, é realizada a busca de todos os médicos ATIVOS no sistema, através de uma busca paginada, ordenada por padrão por ordem alfabética.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/c6f5cffa-8f27-4d5d-9a48-88895efa155c">
  </div>
  <div>
    <h3>GET (/id): </h3>
    <p>Neste endpoint GET, é realizada a busca de um médico por ID, mostrando informações com mais detalhes.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/41612e17-df71-4ce5-a245-da9c98aa9ff5">
  </div>
  <div>
    <h3>PUT (/id): </h3>
    <p>Neste endpoint PUT, é feito a atualização dos dados do médico cujo id foi fornecido na URL, é possível alterar as seguintes informações: </p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/28e5b2c2-4344-4090-8e31-155f7f4132a1">
  </div>
  <div>
    <h3>DELETE (/id): </h3>
    <p>Neste endpoint DELETE, o médico cujo ID fornecido na URL é DESATIVADO do sistema, e não deletado do banco de dados. (antes/depois da deleção de um médico id 2)</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/c6f5cffa-8f27-4d5d-9a48-88895efa155c">
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/70ea87d6-feb7-4217-980a-d0bac56ab64d">
  </div>
  <hr>
  <h2>/pacientes-</h2>
  <div>
    <h3>POST:</h3>
    <p>Neste endpoint POST, inserimos pelo corpo da requisição as informações de um paciente em um json, como mostrado na imagem, tratando a validação das informações.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/65aabfeb-8257-4438-9b5d-fb5c0772e624">
  </div>
  <div>
    <h3>GET: </h3>
    <p>Neste endpoint GET, é realizada a busca de todos os pacientes ATIVOS no sistema, através de uma busca paginada, ordenada por padrão por ordem alfabética.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/364cb415-ce3d-4772-8585-d77edf7de815">
  </div>
  <div>
    <h3>GET (/id): </h3>
    <p>Neste endpoint GET, é realizada a busca de um paciente por ID, mostrando informações com mais detalhes.</p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/0d8dad12-8cb3-4f5f-abed-111096de72b5">
  </div>
  <div>
    <h3>PUT (/id): </h3>
    <p>Neste endpoint PUT, é feito a atualização dos dados do paciente cujo id foi fornecido na URL, é possível alterar as seguintes informações: </p>
    <img src="https://github.com/warleydev/api-clinica-medica/assets/121511600/18e2bedb-2856-4feb-9faf-afbd94612b24">
  </div>
  <div>
    <h3>DELETE (/id): </h3>
    <p>Neste endpoint DELETE, o paciente cujo ID fornecido na URL é DESATIVADO do sistema, e não deletado do banco de dados.</p>
  </div>
  
</div>




