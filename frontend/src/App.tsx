import React from 'react';
import './App.css';
import useWebSocket from "react-use-websocket";

function App() {

    const [messages, setMessages] = React.useState<string[]>()
    const [text, setText] = React.useState("")

    const websocket = useWebSocket("ws://localhost:8080/api/ws/chat", {
        onMessage: event => {
            if (!messages) {
                setMessages(JSON.parse(event.data))
            } else {
                messages.push(event.data)
            }
        }
    })

    function sendChatMessage() {
        websocket.sendMessage(
            text
        )
    }

    function handleTextChange(event: React.ChangeEvent<HTMLInputElement>) {
        setText(event.target.value)
    }

    return (
        <>
            <h1>Chat</h1>

            {
                messages?.map((message, index) => {
                    return <div key={index}>{message}</div>
                })
            }

            <input type={"text"} onInput={handleTextChange}/>

            <button onClick={sendChatMessage} type={"button"}>Send Hi</button>
        </>
    );
}

export default App;
