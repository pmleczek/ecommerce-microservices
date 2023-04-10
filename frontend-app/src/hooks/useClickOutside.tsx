import React, {useEffect} from "react";

const useClickOutside = (ref: React.RefObject<HTMLElement>, callback: () => void) => {
    useEffect(() => {
        const handleClick = (e: MouseEvent) => {
            e.preventDefault();
            if (ref && ref.current && e.target && !ref.current.contains(e.target as Node)) {
                callback();
            }
        }
        document.addEventListener("click", handleClick, true);
        return () => {
            document.removeEventListener("click", handleClick, true);
        }
    }, [ref, callback]);
}

export default useClickOutside;