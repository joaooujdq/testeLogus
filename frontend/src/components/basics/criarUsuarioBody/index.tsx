import { useEffect, useState } from "react";
import api from "../../../services/api";
import React from 'react'
import Alert from 'react-popup-alert'
import './index.css'
const CriarUsuarioBody: React.FC = () => {
    const [post, setPost] = useState(false);
    const [descricao, setDescricao] = useState("");
    const [inputNomeUsr, setInputNomeUsr] = useState('');
    const [inputLoginUsr, setInputLoginUsr] = useState('');
    const [inputSenhaUsr, setInputSenhaUsr] = useState('');
    async function postMsg() {
        let flag2 = false;
        const response = await api.post('/v1/ts/usuarios', {
            "usuario": inputNomeUsr,
            "login": inputLoginUsr,
            "senha": inputSenhaUsr
        }).then(response => response.data)
            .catch(async error => {
                if (error.response) {
                    await setDescricao(error.response.data.descricao)
                    flag2 = true;
                    setPost(!post)
                }
            });
        if (!flag2) {
            window.location.reload();
        }
    }
    useEffect(() => {
        if (post) {
            onShowAlert('error')
        }
    }, [post])
    const [alert, setAlert] = React.useState({
        type: 'error',
        text: descricao,
        show: false
    })
    function onCloseAlert() {
        setAlert({
            type: '',
            text: '',
            show: false
        })
        setPost(!post)
    }
    async function onShowAlert(type: string) {
        await setAlert({
            type: type,
            text: descricao,
            show: true
        })
    }
    return (
        <>
            <Alert
                header={''}
                btnText={'Fechar'}
                text={alert.text}
                type={alert.type}
                show={alert.show}
                onClosePress={onCloseAlert}
                pressCloseOnOutsideClick={true}
                showBorderBottom={true}
                alertStyles={{
                    "background-color": "#f8f9fa",
                    "width": "300px",
                    "height": "100px",
                    "display": "flex",
                    "flex-direction": "column",
                    "align-items": "center",
                    "justify-content": "center",
                    "left": "42%",
                    "bottom": "30%",
                    "border-radius": "8px",
                    "border": "2px solid #C4C4C4",
                    "position": "absolute"
                }}
                headerStyles={{}}
                textStyles={{}}
                buttonStyles={{
                    "background-color": "#efefef",
                    "border-radius": "8px",
                    "margin-bottom": "10px",
                    "text-decoration": "none",
                    "button-decoration": "none",
                    "align-text": "center",
                    "width": "70px",
                    "border": "2px solid #C4C4C4",
                    "height": "30px",
                    "color": "#000",
                    "padding-left": "10px"
                }}
            />
            <body id='CriarUsuarioBody'>
                <h2 id='TitleBar'>Cadastro de Usuario</h2>
                <ul id='CriarUsuarioUl'>
                    <div id='CriarUsuarioForm'>
                        <div id='divH1'>
                            <h1>Nome*: </h1>
                            <h1>Login*: </h1>
                            <h1>Senha*: </h1>
                        </div>
                        <div id='divInput'>
                            <input type="text" value={inputNomeUsr} onChange={e => setInputNomeUsr(e.target.value)} required/>
                            <input type="text" value={inputLoginUsr} onChange={e => setInputLoginUsr(e.target.value)} required/>
                            <input type="text" value={inputSenhaUsr} onChange={e => setInputSenhaUsr(e.target.value)} required/>
                        </div>
                    </div>
                    <button type="submit" onClick={postMsg}>Cadastrar</button>
                </ul>
            </body>
        </>
    );
}
export default CriarUsuarioBody;
