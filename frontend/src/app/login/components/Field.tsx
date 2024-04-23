"use client";
import { useRef, useState } from "react";
import FormInput from "./Input";
import styles from "./styles.module.scss";

export interface FormFieldProps {
	/** Label of the field. */
	label: string;
	/** `name` prop of the input element. */
	name: "username" | "password";
}

/** Bug ao trocar de campo com Tab */
export default function FormField({ label, name }: FormFieldProps) {
	const [active, setActive] = useState(false);
	const [value, setValue] = useState("");
	const inputRef = useRef<HTMLInputElement>(null);

	const className = `${label}-field`;

	function handleClick() {
		function onMouseUpHandler(e: MouseEvent) {
			// @ts-ignore
			if (!e.target?.getAttribute("class")?.includes(className)) {
				window.removeEventListener("mouseup", onMouseUpHandler);
				setActive(false);
			}
		}

		if (!active) {
			window.addEventListener("mouseup", onMouseUpHandler);
		}
		setActive(true);
		inputRef.current?.focus();
	}

	return (
		<div className={`${className} ${styles.field}`} onClick={handleClick}>
			<label
				className={className}
				htmlFor={name}
				onClick={handleClick}
				style={
					active || value
						? {
								fontSize: "0.9rem",
								top: "-0.5rem",
							}
						: {}
				}
			>
				{label}
			</label>

			<FormInput
				className={className}
				inputRef={inputRef}
				name={name}
				onBlur={() => setActive(false)}
				onFocus={() => setActive(true)}
				state={[value, setValue]}
				style={active || value ? { zIndex: 5 } : { zIndex: -1 }}
			/>
		</div>
	);
}
