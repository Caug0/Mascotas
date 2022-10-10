const URL_API = "http://localhost:8080/peliculas"


function get_data_critica(evt){
  //prevenir recarga
  evt.preventDefault()
  const data= evt.target
  const critica={
  titulo: data.titulo.value, 
  anno: data.anno.value,
  director: data.director.value,
  genero: data.genero.value,
  protagonista: data.protagonista.value,
  critica: data.critica.value,
  usuario_Id: data.usuario_id.value
}
  create(critica)
}  
  
 
  async function create (critica) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(critica)
  })
  const text = await resp.text()
  alert(text)
}

