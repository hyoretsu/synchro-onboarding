"use client";
import useUrlStatePush from "@hooks/useUrlStatePush";
import styles from "../styles.module.scss";

export default function EditingFormButtons() {
	const push = useUrlStatePush();

	function closeForm() {
		push(["action", "accountId"], [null, null]);
	}

	return (
		<div className={styles.formButtons}>
			<button type="button" onClick={closeForm}>
				Cancelar
			</button>

			<button type="submit">Salvar</button>
		</div>
	);
}
