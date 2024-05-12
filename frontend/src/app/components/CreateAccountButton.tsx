"use client";
import useUrlStatePush from "@hooks/useUrlStatePush";
import { FiPlusCircle } from "react-icons/fi";

export default function CreateAccountButton() {
	const push = useUrlStatePush();

	return (
		<button type="button" onClick={() => push(["action"], ["creating"])}>
			<FiPlusCircle size="2rem" />
		</button>
	);
}
