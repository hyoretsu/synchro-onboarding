import AccountCard from "./components/AccountCard";
import AccountCreation from "./components/AccountCreation";
import AccountEditing from "./components/AccountEditing";
import CreateAccountButton from "./components/CreateAccountButton";
import styles from "./styles.module.scss";

type SearchParams = "action" | "company" | "type";

interface LoginPageProps {
	searchParams: {
		[key in SearchParams]: string;
	};
}

export default async function Homepage({ searchParams: { action } }: LoginPageProps) {
	const accounts: Account[] = await (await fetch(`${process.env.API_URL}/accounts`)).json();

	return (
		<>
			<main className={styles.main}>
				<CreateAccountButton />

				{action === "creating" && <AccountCreation />}

				<section>
					{accounts.map(account => (
						<>
							<AccountCard key={account.id} account={account} />
							{/* <AccountCard key={account.id} account={account} />
							<AccountCard key={account.id} account={account} />
							<AccountCard key={account.id} account={account} />
							<AccountCard key={account.id} account={account} /> */}
							{/* Num desenvolvimento sério teriam componentes pra reutilizar a lógica desses 2 modais + forms */}
							{action === "editing" && <AccountEditing />}
						</>
					))}
				</section>
			</main>
		</>
	);
}
