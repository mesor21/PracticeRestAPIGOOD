import React, { useState, useEffect } from "react";
import Backend from "../../Backend";

function MainPage(){
  const [lightingData, setLightingData] = useState([]);

  useEffect(() => {
    Backend.LightingAPI.GetFullList().then((data) => {
    setLightingData(data)
    });
  },[]);

  const redirect = (id)=>{
    window.location.href = '/edit/'+id;
  };

  return (
    <table>
      <thead>
        <tr>
          <th>ID</th>
          <th>Red Color</th>
          <th>Blue Color</th>
          <th>Green Color</th>
          <th>Power (W)</th>
          <th>Lux</th>
          <th>Uptime (Days)</th>
          <th>Status</th>
        </tr>
      </thead>
      <tbody>
        {lightingData.map((lighting) => (
          <tr key={lighting.id}>
            <td>{lighting.id}</td>
            <td>{lighting.collor_red}</td>
            <td>{lighting.collor_blue}</td>
            <td>{lighting.collor_green}</td>
            <td>{lighting.power_Wat}</td>
            <td>{lighting.lux}</td>
            <td>{lighting.uptime_days}</td>
            <td>{lighting.status ? "On" : "Off"}</td>
            <td>
              <button onClick={()=>redirect(lighting.id)}>
              </button>
            </td>
          </tr>
        ))}
      </tbody>
    </table>
  );
};

export default MainPage;