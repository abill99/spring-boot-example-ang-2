import React, { useEffect, useState } from 'react';

function ReadFile() {
    const [employees, setEmployee] = useState([]);

    useEffect(() => {
        getAPI("./employee.json")
    }, []);

    const getAPI = (data) => {
        console.log(data)
        fetch(data, {
            headers:
            {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }
        })
            .then(res => res.json())
            .then(data => {
                console.log(data)
                setEmployee(data);
            })
    }



    return (<div >
        <ul>
            {employees.map((record, i) => <li key={i}>{record.id} - {record.firstName} {record.firstName}</li>)}
        </ul>
    </div>
    );

}

export default ReadFile;