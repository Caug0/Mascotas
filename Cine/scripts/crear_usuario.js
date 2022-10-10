const URL_API = "http://localhost:8080/usuario"


function get_data_usuario (evt){
  //prevenir recarga
  evt.preventDefault()
  const data= evt.target
  const usuario={
  user: data.usuario.value, 
  nombre: data.nombre.value,
  password: data.contraseña.value
  }
  create(usuario) 
  
}  
  
 


 async function create (usuario) {
  // Enviar petición
  const resp = await fetch(URL_API, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify(usuario)
  })
  const text = await resp.text()
  alert(text)
}
// create(usuario)
