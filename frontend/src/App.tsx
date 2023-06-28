import React from 'react';
import './App.css';
import useWebSocket from "react-use-websocket";

function App() {

    const websocket = useWebSocket("ws://localhost:8080/api/ws/chat", {
        onMessage: event => {
            console.log(event)
        }
    })

    function sendHi() {
        websocket.sendMessage(
            "hi"
        )
    }

    return (
        <>
            <h1>Chat</h1>
            <button onClick={sendHi} type={"button"}>Send Hi</button>
        </>
    );
}

export default App;
