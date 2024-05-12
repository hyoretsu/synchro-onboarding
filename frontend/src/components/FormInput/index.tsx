"use client";
import type { ChangeEvent, Dispatch, HTMLProps, RefObject, SetStateAction } from "react";

export interface FormInputProps extends HTMLProps<HTMLInputElement> {
	inputRef: RefObject<HTMLInputElement>;
	state: [string, Dispatch<SetStateAction<string>>];
}

export default function FormInput({ inputRef, state: [value, setValue], style, ...rest }: FormInputProps) {
	function handleInput(e: ChangeEvent<HTMLInputElement>) {
		setValue(e.currentTarget.value);
	}

	return <input ref={inputRef} onChange={handleInput} value={value} style={style} {...rest} />;
}
