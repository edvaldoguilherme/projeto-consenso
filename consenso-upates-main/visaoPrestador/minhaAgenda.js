const id = localStorage.getItem("id")
const usuario = localStorage.getItem("nome")



document.addEventListener('DOMContentLoaded', () => {

    fetch("http://localhost:8092/agendamento", {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            let divpai = document.getElementById("div-p")
            for (let index = 0; index < data.length; index++) {
                if (data[index].servico.usuario.idUsuario == id) {
                    const nome = data[index].servico.nome
                    const idAgendamento = data[index].idAgendamento
                    const cliente = data[index].servico.usuario.nome
                    const dia = data[index].data
                    const hora = data[index].hora

                    displayNone()

                   



                }
            }

        })
        .catch((error) => {
            console.error("Error:", error);
        });

})


function displayNone() {

    const divDisplay = document.getElementById("div-p-alert")

    divDisplay.className = "display"
}

function deletaItem(id) {
    console.log(id);
    fetch(`http://localhost:8080/agendamentos/${id}`, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {

        })
        .catch((error) => {
            console.error("Error:", error);
        });
}
function sair(){
    localStorage.clear()
    
}