import { submitForm } from "./actions";
import FormField from "./components/Field";
import FormModal from "./components/Modal";
import styles from "./styles.module.scss";

type SearchParams = "error";

interface LoginPageProps {
	searchParams: {
		[key in SearchParams]: string;
	};
}

export default function LoginPage({ searchParams }: LoginPageProps) {
	const isErrored = JSON.parse(searchParams?.error || "false");

	return (
		<>
			<main className={styles.main}>
				<form className={styles.form} action={submitForm}>
					<FormField label="Usuário" name="username" />

					<FormField label="Senha" name="password" />

					<button type="submit">Entrar</button>
				</form>
			</main>

			{isErrored && <FormModal />}
		</>
	);
}
