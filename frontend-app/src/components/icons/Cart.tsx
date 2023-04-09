import React from "react";
import {IconProps} from "./icons";

const Cart = (props: IconProps) => {
    return (
        <svg xmlns="http://www.w3.org/2000/svg" width={props.width}
             height={props.height} viewBox="0 0 24 24" strokeWidth={props.strokeWidth} stroke="currentColor" fill="none" strokeLinecap="round"
             strokeLinejoin="round">
            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
            <path
                d="M6.331 8h11.339a2 2 0 0 1 1.977 2.304l-1.255 8.152a3 3 0 0 1 -2.966 2.544h-6.852a3 3 0 0 1 -2.965 -2.544l-1.255 -8.152a2 2 0 0 1 1.977 -2.304z"></path>
            <path d="M9 11v-5a3 3 0 0 1 6 0v5"></path>
        </svg>
    );
}

export default Cart;
