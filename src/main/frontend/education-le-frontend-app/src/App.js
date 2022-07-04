import React, {Component} from 'react';
import logo from './logo.svg';
import './App.css';
import employee from './employee.json'
import ledata from './formatted_data.json'
import { pluck, pluck2 } from './dataSplitter.js'

class App extends Component {

    state = {};

        componentDidMount() {
            this.dadJokes();
            
        }

    dadJokes = () => {
        fetch('/api/dadjokes')
            .then(response => response.text())
            .then(message => {
                //this.setState({message: message});
                console.log(message);
                this.setState({message: "Ang!!!!"});
                console.log(employee);
                console.log(ledata);


                
            });
    };

    render() {
        return (
            <div className="App">
            <header className="App-header">
            <img src={logo} className="App-logo" alt="logo"/>
            <h3 className="App-title">Hello World {this.state.message}</h3>
            <div >{JSON.stringify(employee)}</div>
            <div >{/*JSON.stringify(ledata)*/}</div>
            <div >
            <ul>
                {employee.map(
                (record, i) => 
                <li key={i}>{record.id} - {record.firstName} {record.firstName}
                <p>456</p>
                </li>
                )
                }
            </ul>
            </div>

            <div >
            <ul>

            {console.log("PLUCK2>>>>>>>>>")}
            {console.log(ledata.info)}


                {pluck2(ledata.info, 'type')}
                {pluck2(ledata.info, 'widget_type')}
                
                {pluck2(ledata.info, 'stimulus')}
                
    
                {ledata.info.map(
                (record, i) => 
                
                <li key={i}>{record.type} - {record.widget_type}  {console.log(record)}
                 <p>789</p>
                {
                //record.keys.forEach ((values,keys)=><p>910</p>)
                }
                
                </li>
                )
                }
            </ul>
            </div>

            <div >
            <ul>
           
            {ledata.info.map(
                (record, i) => 
                <li key={i}>{console.log("KEYSSSS"+ record.keys)}{record.type} - {record.widget_type} {record.reference}
                
                </li>
                )
                }
            </ul>
            </div>

            </header>
            <p className="App-intro">
            To get started, edit <code>src/App.js</code> and save to reload.
        </p>
        </div>
    );
    }
}

export default App;