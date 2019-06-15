function getNavi(container, navi) {
 let url = 'https://staging-api.naviaddress.com/api/v1.5/Addresses/'+container+'/'+navi;
    fetch(url).then((response)=>{
        return response.json()
    }).then((naviData)=>{
        console.log(naviData.result);
        console.log(naviData.result.point);

        if(selectedValue == 'Chateau Margaux 2004'){
            latWine.push(naviData.result.point.lat);
            lngWine.push(naviData.result.point.lng);
            descriptonWine.push(naviData.result.description);

            descriptonWine.forEach((elem, index)=>{
                var contentString = '<div>'+ descriptonWine[index]+'</div>'
                var infowindow = new google.maps.InfoWindow({
                    content: contentString
                });

                var latLng = new google.maps.LatLng(latWine[index], lngWine[index]);
                markerWine[index] = new google.maps.Marker({
                    position: latLng,
                    map: map,
                    title: 'Description',
                    icon: {
                        url: './anchor-153304_960_720.png', // url
                        scaledSize: new google.maps.Size(40, 70), // scaled size
                        origin: new google.maps.Point(0,0), // origin
                        anchor: new google.maps.Point(0,0) // anchor
                    }

                });
                markerWine[index].addListener('click', function() {
                    infowindow.open(map, markerWine[index]);
                });
                markerWine[index].setMap(map);
            })

        }
        if(selectedValue == 'Prednisolone'){
            latDrags.push(naviData.result.point.lat);
            lngDrags.push(naviData.result.point.lng);
            descriptonDrags.push(naviData.result.description);

            descriptonDrags.forEach((elem, index)=>{
                var contentString = '<div>'+ descriptonDrags[index]+'</div>'
                var infowindow = new google.maps.InfoWindow({
                    content: contentString
                });

                var latLng = new google.maps.LatLng(latDrags[index], lngDrags[index]);
                markerDrags[index] = new google.maps.Marker({
                    position: latLng,
                    map: map,
                    title: 'Description',
                    icon: {
                        url: './anchor-153304_960_720.png', // url
                        scaledSize: new google.maps.Size(40, 70), // scaled size
                        origin: new google.maps.Point(0,0), // origin
                        anchor: new google.maps.Point(0,0) // anchor
                    }

                });
                markerDrags[index].addListener('click', function() {
                    infowindow.open(map, markerDrags[index]);
                });
                markerDrags[index].setMap(map);
            })
        }



    })

}




