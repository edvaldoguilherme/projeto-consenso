const nome = document.getElementById("nomeinput")
const descricao = document.getElementById("descricaotextarea")

async function passarParaBack(event){
event.preventDefault();
    console.log(nome)
    await fetch("https://localhost:8092/servico",{
        method: "POST",
        headers: {
            "Content-Type": "application/json",
        },
        body: JSON.stringify({
            nome: nome.value,
            descricao: descricao.value
        })
    .then((response)=>response.json())
    .then((data)=>{
        console.log("Success", data);
    })
})
}