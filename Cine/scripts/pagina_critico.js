
function get_para(){
  const search= window.location.search
  const url= new URLSearchParams(search)
  const param_usuario= url.get("obj")
  const usuario= JSON.parse(param_usuario)
  return  URL_API = "http://localhost:8080/peliculas/fullname?usuario_Id="+ usuario.id

}



function show (Peliculas){ 
    let card= ""
    // Iterar array
    for (let i = 0; i < Peliculas.length ; i++) {
        const obj = Peliculas[i]
        card +=`
            <article class="card">
                <div class= "body-card">
                        <h2>${obj.titulo}</h2>
                        <span>Director: ${obj.director}</span>  
                        <span>Genero: ${obj.genero}</span>
                        <span>Año estreno: ${obj.anno}</span>
                        <span>Protagonista: ${obj.protagonista}</span>
                        <article> <span >Critica:${obj.critica} </span></article>
                        <button class="btn btn-danger" onclick="delete_resena(${obj.id})">Eliminar</button>
                        </div>
            </article>`}
    document.getElementById('section-cards').innerHTML = card
  }


async function getusuario_Id () {
  // Enviar petición
  const resp = await fetch(URL_API)
  // Obtener datos de la petición
  const Peliculas = await resp.json()
  return Peliculas
}

async function delete_resena (id) {
  // Enviar petición
  const resp = await fetch("http://localhost:8080/peliculas/"+id, {
    method: 'DELETE'
  })
  const text = await resp.text()
  // alert(text)
  main()
}
      
async function main () {
    get_para()
    const Peliculas = await getusuario_Id()
    show(Peliculas)
   
  }
      
main()