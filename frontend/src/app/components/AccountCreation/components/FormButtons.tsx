"use client";
import useUrlStatePush from "@hooks/useUrlStatePush";
import styles from "../styles.module.scss";

export default function CreationFormButtons() {
	const push = useUrlStatePush();

	function closeForm() {
		push(["action"], [null]);
	}

	return (
		<div className={styles.formButtons}>
			<button type="button" onClick={closeForm}>
				Cancelar
			</button>

			<button type="submit">Criar</button>
		</div>
	);
}
