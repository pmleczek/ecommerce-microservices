import React from "react";
import {IconProps} from "./icons";

const ChevronUp = (props: IconProps) => {
    return (
        <svg xmlns="http://www.w3.org/2000/svg" width={props.width} height={props.height} viewBox="0 0 24 24"
             strokeWidth={props.strokeWidth} stroke="currentColor" fill="none" strokeLinecap="round"
             strokeLinejoin="round">
            <path stroke="none" d="M0 0h24v24H0z" fill="none"></path>
            <path d="M6 15l6 -6l6 6"></path>
        </svg>
    );
}

export default ChevronUp;
