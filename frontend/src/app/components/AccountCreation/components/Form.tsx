import { createAccount } from "@app/actions";
import FormField from "@components/FormField";
import styles from "../styles.module.scss";
import CreationFormButtons from "./FormButtons";

export default function CreationForm() {
	return (
		// Outra forma de fazer, porém essa não ativa um reload da página
		<form className={styles.form} action={createAccount}>
			<FormField label="Empresa" name="company" />

			<FormField label="Serviço" name="type" />

			<CreationFormButtons />
		</form>
	);
}
