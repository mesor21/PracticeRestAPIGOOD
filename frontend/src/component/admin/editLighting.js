import React from 'react'

function EditLighting(){
return (<>
<div class="blog">
    <div class="container">
        <p>Параметры сотрудника</p>
        {/* <table>
            <thead>
            <th>ID</th>
            <th>R(0-255)</th>
            <th>G(0-255)</th>
            <th>B(0-255)</th>
            <th>Мощность</th>
            <th>Освещённость</th>
            <th>Срок службы(дней)</th>
            </thead>
            <tbody>
            <tr th:each="lighting: ${lighting}">
                <form th:action="'/edit/' + ${lighting.getId}" method="post">
                    <table style="{width: 100%}">
                        <tr>
                            <td text=${lighting.getId}></td>
                            <td><input th:value="${lighting.getCollor_red}" type="text" id="collor_red"
                                       name="collor_red">
                            </td>
                            <td><input th:value="${lighting.getCollor_green}" type="text" id="collor_green"
                                       name="collor_green">
                            </td>
                            <td><input th:value="${lighting.getCollor_blue}" type="text" id="collor_blue"
                                       name="collor_blue">
                            </td>
                            <td><input th:value="${lighting.getPower_Wat}" type="text" id="power_Wat" name="power_Wat">
                            </td>
                            <td><input th:value="${lighting.getLux}" type="text" id="lux" name="lux"></td>
                            <td><input th:value="${lighting.getUptime_days}" type="text" id="uptime_days"
                                       name="uptime_days">
                            </td>
                            <td>
                            <td th:value="${lighting.getStatus}" name="status"></td>
                        </tr>
                        <tr>
                            <td colspan="7">
                                <div class="tableFooter">
                                    <a th:href="@{/delete/{id}(id=${lighting.getId})}">
                                        <button class="btn1" type="button">Удалить</button>
                                    </a>
                                    <a th:href="'/edit/' + ${lighting.getId}">
                                        <button class="btn1" type="submit"> Подтвердить пользователя
                                        </button></a>

                                </div>
                            </td>
                        </tr>
                    </table>
                </form>
            </tr>
            </tbody>
        </table> */}


    </div>
</div>
</>);
}
export default EditLighting;