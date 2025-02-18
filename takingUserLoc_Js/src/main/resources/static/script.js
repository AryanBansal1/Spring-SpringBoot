//   IN ORDER TO WORK BASED ON A BUTTON CLICK
// const button = document.getElementById('ask-permission')

// button.addEventListener('click',async()=>{
//     const result = navigator.geolocation.getCurrentPosition(gotLocation,failedToGetLocation)
// }
// )

if(navigator.geolocation){
    navigator.geolocation.getCurrentPosition(gotLocation,failedToGetLocation)
}
else{
    document.getElementById('para-location').innerHTML="Geolocation is not supported by this browser."
}

function gotLocation(positon){
    let latitude = positon.coords.latitude
    let longitude = positon.coords.longitude
    console.log(latitude +" " +longitude)
}

function failedToGetLocation(){
    console.log('failed to take the user location')
}

