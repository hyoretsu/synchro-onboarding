"use client";
import { deleteAccount } from "@app/actions";
import useUrlStatePush from "@hooks/useUrlStatePush";
import { useRouter } from "next/navigation";
import { BsPencil, BsTrash } from "react-icons/bs";
import styles from "./styles.module.scss";

interface AccountCardProps {
	account: Account;
}

export default function AccountCard({ account }: AccountCardProps) {
	const router = useRouter();
	const push = useUrlStatePush();

	return (
		<div className={styles.card}>
			<h4>{account.company}</h4>
			<span>{account.type}</span>

			<div className={styles.actions}>
				<button
					type="button"
					onClick={() => {
						push(["action", "accountId"], ["editing", account.id]);
					}}
				>
					<BsPencil size="1.5rem" />
				</button>
				<button
					type="button"
					onClick={() => {
						// Acharia melhor mudar pra context e alterar localmente sem fzr outra requisição pro back
						deleteAccount(account.id);
						router.refresh();
					}}
				>
					<BsTrash size="1.5rem" />
				</button>
			</div>
		</div>
	);
}
