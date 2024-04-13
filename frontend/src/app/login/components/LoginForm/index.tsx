import FormField from "./components/Field";
import styles from "./styles.module.scss";

export default function LoginForm() {
	return (
		<form className={styles.form}>
			<FormField label="Usuário" />

			<FormField label="Senha" />
		</form>
	);
}
