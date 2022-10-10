const URL_API = "http://localhost:8080/usuario"

//Conseguir usuarios de la base de datos
async function get_usuarios () {
  // Enviar petición
  const resp = await fetch(URL_API)
  // Obtener datos de la petición
  const usuarios = await resp.json()
  return usuarios} 

//capturar usuario y contraseña del html
function get_data_inicio (evt){
    //prevenir recarga
    evt.preventDefault()
    const data= evt.target
    c= data.usuario.value
    p= data.password.value   
    async function main () {
        const usuarios = await get_usuarios()
        comparar( c, p, usuarios)
        }
    main()
    } 



//comparar
function comparar(c, p, usuarios){
    c, p
    for (let i=0; i< usuarios.length; i++){
        const obj= usuarios[i]
        if (obj.user == c && obj.password == p)
            window.location.href="pagina_critico.html?obj="+ JSON.stringify(obj)        
        }
        
    
     
}


          



