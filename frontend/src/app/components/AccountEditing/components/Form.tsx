"use client";
import { editAccount } from "@app/actions";
import FormField from "@components/FormField";
import useUrlStatePush from "@hooks/useUrlStatePush";
import { useSearchParams } from "next/navigation";
import styles from "../styles.module.scss";
import EditingFormButtons from "./FormButtons";

export default function EditingForm() {
	const searchParams = useSearchParams();
	const push = useUrlStatePush();

	return (
		<form
			className={styles.form}
			onSubmit={e => {
				e.preventDefault();
				const formData = new FormData(e.target);
				// Pensar em validação, não sei bem como faz com server actions pra mostrar pro usuário
				editAccount({
					id: searchParams.get("accountId")!,
					...Object.fromEntries([...formData.entries()].filter(([_, value]) => value)),
				});
				window.location.href = "/";
			}}
		>
			<FormField label="Empresa" name="company" />

			<FormField label="Serviço" name="type" />

			<EditingFormButtons />
		</form>
	);
}
