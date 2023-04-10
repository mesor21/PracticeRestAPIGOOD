import React, { useState, useEffect } from 'react';
import axios from 'axios';


function LightingAPI(){
  const [lightingList, setLightingList] = useState([]);

  useEffect(() => {
    axios.get('/api/main')
      .then(response => {
        setLightingList(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  }, []);

  const createNew = () => {
    axios.post('/api/create')
      .then(response => {
        setLightingList(response.data);
      })
      .catch(error => {
        console.log(error);
      });
  };

  const getForEdit = (id) => {
    axios.get(`/api/edit/${id}`)
      .then(response => {
        // handle the response
      })
      .catch(error => {
        console.log(error);
      });
  };

  const saveEdit = (lighting) => {
    axios.post(`/api/edit/${lighting.id}`, lighting)
      .then(response => {
        // handle the response
      })
      .catch(error => {
        console.log(error);
      });
  };

  const deleteLighting = (id) => {
    axios.delete(`/api/delete/${id}`)
      .then(response => {
        setLightingList(lightingList.filter(lighting => lighting.id !== id));
      })
      .catch(error => {
        console.log(error);
      });
  };

  const switchLight = (id) => {
    axios.get(`/api/info/switchLight/${id}`)
      .then(response => {
        // handle the response
      })
      .catch(error => {
        console.log(error);
      });
  };
}

export default LightingAPI;