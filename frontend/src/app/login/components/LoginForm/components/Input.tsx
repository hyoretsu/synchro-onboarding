"use client";
import type { ChangeEvent, Dispatch, HTMLProps, SetStateAction } from "react";

export interface FormInputProps extends HTMLProps<HTMLInputElement> {
	state: [string, Dispatch<SetStateAction<string>>];
}

export default function FormInput({ ref, state: [value, setValue], style }: FormInputProps) {
	function handleInput(e: ChangeEvent<HTMLInputElement>) {
		console.log(e.currentTarget.value);

		setValue(e.currentTarget.value);
	}

	return <input ref={ref} onChange={handleInput} value={value} style={style} />;
}
