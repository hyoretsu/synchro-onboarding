"use client";
import { useEffect, useRef, useState } from "react";
import styles from "../styles.module.scss";
import Input from "./Input";

export interface FormFieldProps {
	/** Label of the field. */
	label: string;
}

export default function FormField({ label }: FormFieldProps) {
	const [active, setActive] = useState(false);
	const [value, setValue] = useState("");
	const inputRef = useRef<HTMLInputElement>(null);

	const className = `${label}-field`;

	useEffect(() => {
		setActive(old => old || !!value);
	}, [value]);

	function handleClick() {
		function onMouseUpHandler(e: MouseEvent) {
			// @ts-ignore
			if (!e.target?.getAttribute("class")?.includes(className)) {
				window.removeEventListener("mouseup", onMouseUpHandler);
				setActive(false);
			}
		}

		if (!active) {
			setActive(true);
			window.addEventListener("mouseup", onMouseUpHandler);
		}
	}

	return (
		<div
			className={`${className} ${styles.field}`}
			onFocus={() => console.log("asaaaaaa")}
			onClick={handleClick}
		>
			<label
				style={
					active
						? {
								backgroundColor: "#fff",
								position: "absolute",
								fontSize: "0.9rem",
								top: "-0.5rem",
							}
						: {}
				}
			>
				{label}
			</label>
			<Input
				ref={inputRef}
				onBlur={() => setActive(value ? true : false)}
				state={[value, setValue]}
				style={{
					display: !active ? "none" : "block",
				}}
			/>
		</div>
	);
}
