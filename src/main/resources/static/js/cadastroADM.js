function VerificaLogin(){
            var usuario="administrador"
            var senha= "admin"
            var login=document.getElementById("txtLogin").value;
            var senhaInserida = document.getElementById("txtSenha").value;

            if(usuario == login && senha == senhaInserida ){
                window.open('/exibeCinema','_self')
            }
            else if (usuario != login){
                alert("O Usuario está incorrento, tente novamente");
            }
            else {
                alert("Senha incorreta, tente novamente!");
            }


        }