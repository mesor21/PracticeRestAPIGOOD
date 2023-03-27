import React, { useState } from 'react';
import { Link } from 'react-router-dom';
import axios from "axios";

function MainPage(){
    const [lights, setLights] = useState([]);
    const [newLight, setNewLight] = useState({
      colorRed: 0,
      colorBlue: 0,
      colorGreen: 0,
      powerWat: 0,
      lux: 0,
      uptimeDays: 0,
      status: false
    });

    // useEffect(() => {
    //     axios.get('/api/main')
    //       .then(response => setLights(response.data))
    //       .catch(error => console.error(error));
    //   }, []);
    
    // const handleInputChange = (event) => {
    //   const { name, value } = event.target;
    //   setNewLight({ ...newLight, [name]: value });
    // };
    
    const handleFormSubmit = (event) => {
      event.preventDefault();
      axios.post('/api/main', newLight)
        .then(response => setLights([...lights, response.data]))
        .catch(error => console.error(error));
    };
    return (<>
<div class="blog">
    <p>Список устройст освещения</p><br></br>
        <table>
            <thead>
            <th>ID</th>
            <th>R</th>
            <th>G</th>
            <th>B</th>
            <th>Мощность</th>
            <th>Освещённость</th>
            <th>Срок службы</th>
            <th>Статус</th>
            <th>Редактирование</th>
            </thead>
            {lights.map(light =>(
            <tr key={light.id}>
                <td text="${light.Id}"></td>
                <td text="${light.colorRed}"></td>
                <td text="${light.colorGreen}"></td>
                <td text="${light.collorBlue}"></td>
                <td text="${light.powerWat}"></td>
                <td text="${light.lux}"></td>
                <td text="${light.uptimeDays}"></td>
                <td text="${light.status}"></td>
                <td><Link to="/edit/{light.id}"
                       class="btn3">Редактировать</Link></td>
            </tr>
            ))}
        </table> 
    <form onSubmit={handleFormSubmit}>
        <button class="btn1 button" type="submit">Добавить тему</button>
    </form>
</div>
</>);
}
export default MainPage;