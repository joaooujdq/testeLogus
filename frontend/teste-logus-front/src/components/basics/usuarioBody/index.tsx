import { useEffect, useState } from "react";
import React from 'react';
import Popup from 'reactjs-popup';
import 'reactjs-popup/dist/index.css';
import api from "../../../services/api";
import { FiArrowLeft, FiArrowRight } from "react-icons/fi";
import { Form } from "react-bootstrap";
import './index.css'
interface iusuario {
    idcadusuario: number,
    dcr_usuario: string,
    dcr_login: string,
    dcr_senha: string,
    dat_cadastro: string,
    dat_desativar: string,
    links_: i_links
}
interface i_links {
    self: iself
}
interface iself {
    href: string
}
const UsrBody: React.FC = () => {
    const [Usr, setUsr] = useState<iusuario[]>([]);
    const [Limit, setLimit] = useState<iusuario[]>([]);
    const [direction, setDirection] = useState('desc');
    const [page, setPage] = useState(0);
    useEffect(() => {
        const loadMsg = async () => {
            const response = await api.get('/v1/ts/usuarios/', { params: { page: page, limit: 3, direction: direction } });
            const limit = await api.get('/v1/ts/usuarios/');
            if (Object.keys(response.data).length) {
                setUsr((response).data._embedded.usuarioDTOList);
            } else {
                setUsr([]);
            }
            setLimit((limit).data._embedded.usuarioDTOList);
        }
        loadMsg()
    }, [page]);
    
    const deleteMsg = async (codigo: string) => {
            const responseDelete = await api.delete('/v1/ts/usuarios/' + codigo);
            window.location.reload()
    }
    return (
        <>
            <body>
                <thead>
                    {
                        Usr.map(m => (
                            <ul id='usrBody'>
                                <li><strong>idcadusuario: {m.idcadusuario}</strong></li>
                                <li><strong>dcr_usuario: {m.dcr_usuario}</strong></li>
                                <li><strong>dcr_login: {m.dcr_login}</strong></li>
                                <li><strong>dcr_senha: {m.dcr_senha}</strong></li>
                                <li><strong>dat_cadastro: {m.dat_cadastro}</strong></li>
                                <Popup trigger={<li className='deleteButton' ><strong >EXCLUIR USUARIO</strong></li>} position="bottom center">
                                    <button className='confDelete' onClick={() => { deleteMsg(m.idcadusuario.toString()) }}>Clique aqui para confirmar.</button>
                                </Popup>
                            </ul>
                        ))
                    }
                </thead>
            </body>
            <div id='carouselBar'>
                <FiArrowLeft id='carouselIcon' onClick={() => { if (page - 1 >= 0) setPage(page - 1) }} />
                <FiArrowRight id='carouselIcon' onClick={() => { if (Usr.length == 3 && page + 1 < Limit.length / 3) { setPage(page + 1) } }} />
            </div>
        </>
    );
}
export default UsrBody;
