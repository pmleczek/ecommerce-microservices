import React, {useCallback, useRef, useState} from "react";
import useClickOutside from "../hooks/useClickOutside";
import ChevronDown from "./icons/ChevronDown";
import ChevronUp from "./icons/ChevronUp";
import "../style/select.css";

interface SelectOption {
    title: string;
    value: string;
}

interface Props {
    initialValue: string;
    options: SelectOption[];
    onChange: (newValue: string | null) => void;
    className?: string;
}

const Select = (props: Props) => {
    const [show, setShow] = useState<boolean>(false);
    const ref = useRef<HTMLDivElement>(null);
    const hide = useCallback(() => {
        setShow(false);
    }, []);
    useClickOutside(ref, hide);

    const [value, setValue] = useState<string | null>(props.initialValue);

    const handleClick = (e: React.MouseEvent<HTMLDivElement>) => {
        if (e.target instanceof Element) {
            setValue(e.target.getAttribute("data-option"));
            props.onChange(e.target.getAttribute("data-option"));
        }
    }

    return (
        <div
            className={"pointer relative bg-light-gray border-radius-05 select flex align-center justify-between "
                + props.className + (show ? " show" : "")}
            onClick={e => setShow(!show)} ref={ref}>
            <div className="flex px-1 w-full align-center justify-between">
                <span>{props.options.filter(option => option.value === value)[0].title}</span>
                {show ? <ChevronUp width={20} height={20} strokeWidth={2}/> :
                    <ChevronDown width={20} height={20} strokeWidth={2}/>}
            </div>
            <div onClick={handleClick}
                 className={show ? "absolute select-options border-1 border-solid border-light-gray w-full" : "none"}
                 style={{"bottom": `${(props.options.length - 1) * -43}px`}}>
                {props.options.filter(option => option.value !== value).map(option => (
                    <div className="px-1 bg-light-gray w-full" key={option.value} data-option={option.value}>{option.title}</div>
                ))}
            </div>
        </div>
    );
}

export default Select;
